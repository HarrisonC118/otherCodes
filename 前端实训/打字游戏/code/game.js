// 定义画布和画笔
var gameCanvas, gameContext
// 定义画布的宽高
var cW = 724,
    cH = 433
// 音乐的播放(1)和停止(0)
var playIndex = 1

var letters = []
var keySound
var score = 0

window.onload = function () {
    gameCanvas = document.querySelector('.game_canvas')
    gameContext = gameCanvas.getContext("2d")
    keySound = document.querySelector('.mp3')
}
// 音乐的播放和停止
function playMusic(obj) {
    console.log(obj.innerHTML)
    var bgmp3 = document.querySelector('.bgmp3')
    if (playIndex === 1) {
        bgmp3.pause()
        playIndex = 0
        obj.innerHTML = '音乐关'
    } else {
        bgmp3.play()
        playIndex = 1
        obj.innerHTML = '音乐开'
    }
}
//定义类 第一个单词的首字母大写

class Letter {
    constructor() {
        this.w = 59 //宽
        this.h = 77 //高
        this.g = 2 //纵坐标加速度
        this.x = Math.random() * cW - this.w
        this.y = -this.h
        this.liveTime = 0 //当前存活时间
        this.isDanger = Math.ceil(Math.random() * 10) >= 8?true:false //当数值大于8时为危险按钮
        if (this.x < 0) {
            this.x = 0
        }
        //Math.ceil 向上取整
        this.num = Math.ceil(Math.random() * 26)
        //获得字母对应的编码
        this.keyCode = this.num + 64
        //获得图片
        this.setLiveTime()
        this.img = getImage("../source/img/letter_" + this.num + ".png")
    }
    updateFrame() {
        //速度随着时间的推移逐渐加快

        this.y += this.g * this.liveTime / 500
    }
    drawLetter() {
        if(this.isDanger){
            gameContext.fillStyle = "#FF0000"; 　
            gameContext.fillRect(this.x, this.y,this.w,this.h); 
        }
        gameContext.drawImage(this.img, this.x, this.y, this.w, this.h)
        
        //drawImage(图片地址,x坐标,y坐标,图片的高度,图片的宽度)
    }
    setLiveTime() {
        setInterval(() => {
            this.liveTime += 10
        }, 10)
    }
}
// 获取图片


function getImage(obj) {
    var img = new Image()
    img.src = obj
    return img
}
// 游戏开始
function gameStart() {
    gameCanvas.style.display = "block"
    //每一秒创建一个字母
    setInterval(() => {
        createLetter()
    }, 500)
    setInterval(() => {
        gameTick()
    }, 10)
    onkeydown = keyDwon

}
// 创建字母
function createLetter() {
    var letter = new Letter()
    letters.push(letter)
    console.log(letter.isDanger)
}
// 把字母画到画布上
function gameTick() {
    //清空画布,从(0,0)到(画布的宽,画布的高)清空
    gameContext.clearRect(0, 0, cW, cH)
    //遍历字母数组
    for (var i = 0; i < letters.length; i++) {
        var lett = letters[i]
        lett.updateFrame()
        lett.drawLetter()
        if (lett.y > cH) {
            letters.splice(i, 1)
            if(!lett.isDanger){
                score -= 8
            }
            drawNumImg(score)
        }
    }
}

function keyDwon(e) {
    var ev = e || window.event
    keySound.src = '../source/music/btnpressed.ogg'
    for (var a = 0; a < letters.length; a++) {
        var lett = letters[a]
        if (lett.keyCode === ev.keyCode) {
            if(lett.isDanger){
                score -= 10
                // 如果按到危险按钮，画面抖动一秒钟,分数减10
                gameCanvas.className = 'game_canvas dongdongdong'
                //更改分数的图片
                drawNumImg(score)

                letters.splice(a, 1)
                if (playIndex === 1) {
                    keySound.src = '../source/music/bloser.mp3'
                    keySound.play()
                }
                setTimeout(()=>{
                    gameCanvas.className = 'game_canvas'
                },500)
                break
            }else {
                score += 13
                //更改分数的图片
                drawNumImg(score)

                letters.splice(a, 1)
                if (playIndex === 1) {
                    keySound.src = '../source/music/bloser.mp3'
                    keySound.play()
                }
                break
            }
        }
        keySound.play()
        score -= 5
        drawNumImg(score)
    }
}

function drawNumImg(num) {
    if (num < 0) {
        score = 0
        num = 0
    }
    var arrnum = [0, -15, -30, -45, -60, -75, -90, -105, -120, -135]
    var str_num = ""
    var s_num = String(num)

    for (var i = 0; i < s_num.length; i++) {
        var item = Number(s_num[i])
        var point = arrnum[item]
        str_num += '<div class="num_01" style="background-position-x:' + point + "px" + '"></div>'
    }
    var scoreNode = document.querySelector(".scoreImg")
    scoreNode.style.width = 15 * s_num.length + "px"
    scoreNode.innerHTML = str_num
}