// 定义俄罗斯方块的形状
var layouts = [
    [
        [1, 1, 1, 1]
    ],
    [
        [1, 1],
        [1, 1]
    ],
    [
        [0, 1, 0],
        [1, 1, 1]
    ],
    [
        [1, 1, 0],
        [0, 1, 1]
    ],
    [
        [0, 1, 1],
        [1, 1, 0]
    ],
    [
        [1, 0, 0],
        [1, 1, 1]
    ],
    [
        [0, 0, 1],
        [1, 1, 1]
    ]
]
// var layouts = [
//     [
//         [1, 1, 1, 1]
//     ],
//     [
//         [1, 1, 1, 1]
//     ],
//     [
//         [1, 1, 1, 1]
//     ],
//     [
//         [1, 1, 1, 1]
//     ],
//     [
//         [1, 1, 1, 1]
//     ],
//     [
//         [1, 1, 1, 1]
//     ],
//     [
//         [1, 1, 1, 1]
//     ]
// ]
var yellowButton = document.querySelector(".yellow")
var gameCanvas = document.querySelector('#gameCanvas')
var gameContext = gameCanvas.getContext("2d")
var nextCanvas = document.querySelector('#nextCanvas')
var nextContext = nextCanvas.getContext("2d")
var c = [0, 20, 40, 60, 80, 100, 120]
var eShape; //eShape代表了一个俄罗斯方块
var nextShape; //下一个俄罗斯方块
var isStart = true
var imgs = document.querySelectorAll('img')
var newLayout = []
var blockWidth, blockHeight //每个方格的长宽
var list = []
var percentage = document.querySelector('.percentage')
var progress = document.querySelector(".progress")
var number = 0
var sc = 0
document.querySelector(".yellow").disabled=true
blockWidth = window.innerWidth * 0.6 / 10
blockHeight = blockWidth
// 设置画布的宽度和高度
gameCanvas.width = blockWidth * 10
gameCanvas.height = blockHeight * 20
nextCanvas.width = blockWidth * 4
nextCanvas.height = blockHeight * 2

var timer = setInterval(() => {
    move()
}, 500);

for (var i = 0; i < imgs.length; i++) {
    var img = imgs[i]
    img.index = i
    img.onclick = function () {
        keyAndDown(this.index)
    }
}

function keyAndDown(index) {
    switch (index) {
        case 0: // 暂停
            if (isStart) {
                clearInterval(timer)
                imgs[0].src = "../source/img/bofang.png"
            } else {
                imgs[0].src = "../source/img/zanting.png"
                timer = setInterval(() => {
                    move()
                }, 500)
            }
            isStart = !isStart
            break

        default:
            if (isStart) {
                switch (index) {
                    case 1: //变形
                        newLayout = []
                        changeLayout()
                        break
                    case 2: //加速
                        if (isMove(0, 1)) {
                            eShape.currentY += 1
                        }
                        break
                    case 3: //向左
                        if (isMove(-1, 0)) {
                            eShape.currentX -= 1
                        }
                        break
                    case 4: //向右
                        if (isMove(1, 0)) {
                            eShape.currentX += 1
                        }
                        break
                }
            }

    }
}

function drawLine() {
    // 横线21根
    for (var i = 0; i < 21; i++) {
        gameContext.beginPath()
        gameContext.strokeStyle = "white"
        gameContext.lineWidth = 2
        // 起点坐标
        gameContext.moveTo(0, blockHeight * i)

        //终点坐标
        gameContext.lineTo(blockHeight * 10, blockHeight * i)

        gameContext.stroke()
        gameContext.closePath()
    }
    for (var j = 0; j < 11; j++) {
        gameContext.beginPath()
        gameContext.strokeStyle = "white"
        gameContext.lineWidth = 2
        // 起点坐标
        gameContext.moveTo(blockHeight * j, 0)

        //终点坐标
        gameContext.lineTo(blockHeight * j, blockHeight * 20)

        gameContext.stroke()
        gameContext.closePath()
    }
    // 竖线11根
}
class Shape {
    constructor() {
        this.currentX = 3
        this.currentY = 0
        this.img = getImage()
        this.layout = layouts[Math.floor(Math.random() * 7)]
        //设置图片
        //生成0~6的随机数，Math.floor是向下取整
        this.color = Math.floor(Math.random() * 7)
        //定义形状
    }
    drawShape() {
        for (var i = 0; i < this.layout.length; i++) {
            for (var j = 0; j < this.layout[0].length; j++) {
                if (this.layout[i][j] != 0) {
                    gameContext.drawImage(this.img, c[Number(this.color)], 0, 20, 20, (this.currentX + j) * blockWidth, (this.currentY + i) * blockHeight, blockWidth, blockHeight)
                }
            }
        }
    }
}
// 定义下一个方块
class NextShape {
    constructor() {
        this.img = getImage()
    }
    updateFrame() {
        this.color = Math.floor(Math.random() * 7)
        this.layout = layouts[Math.floor(Math.random() * 7)]
    }
    drawNextShape() {
        for (var i = 0; i < this.layout.length; i++) {
            for (var j = 0; j < this.layout[0].length; j++) {
                if (this.layout[i][j] > 0) {
                    nextContext.drawImage(this.img, c[Number(this.color)], 0, 20, 20, j * blockWidth, i * blockHeight, blockWidth, blockHeight)
                }
            }
        }
    }
}

function isMove(x, y) {
    var nextY = eShape.currentY + y
    var nextX = eShape.currentX + x

    if (nextY > 20 - eShape.layout.length) {
        return false
    }
    if (nextX < 0 || nextX > 10 - eShape.layout[0].length) {
        return false
    }
    //判断正在下落的方块和不再下落的方块是否重叠
    for (var i = 0; i < eShape.layout.length; i++) {
        for (var j = 0; j < eShape.layout[0].length; j++) {
            if (eShape.layout[i][j] > 0 && list[nextY + i][nextX + j] > 0) {
                return false
            }
        }
    }
    return true
}

createList()

function getImage() {
    var img = new Image()
    img.src = "../source/img/blocks1.png"
    return img
}
eShape = new Shape()
nextShape = new NextShape()



nextShape.img.onload = function () {
    nextShape.updateFrame()
    nextShape.drawNextShape()
}


function move() {
    // 方块的下落
    if (isMove(0, 1)) {
        eShape.currentY += 1
    } else {
        console.log("落不了了")

        // 重置俄罗斯方块并把下一个俄罗斯方块的信息赋给俄罗斯方块
        pushShapeToList()
        clearList()
        eShape.currentX = 3
        eShape.currentY = 0
        eShape.color = nextShape.color
        eShape.layout = nextShape.layout

        //判断游戏是否结束(第一行的方块是否重叠)
        for (var i = 0; i < eShape.layout.length; i++) {
            for (var j = 0; j < eShape.layout[0].length; j++) {
                if (eShape.layout[i][j] > 0 && list[eShape.currentY + i][eShape.currentX + j] > 0) {
                    window.location.reload(0)
                }
            }
        }


        // 生成下一个俄罗斯方块
        nextShape.updateFrame()
        nextContext.clearRect(0, 0, nextCanvas.width, nextCanvas.height)
        nextShape.drawNextShape()
    }
    updateCanvas()

}

// 更新画布的函数
function updateCanvas() {
    // 清空画布
    gameContext.clearRect(0, 0, gameCanvas.width, gameCanvas.height)
    // 画网格
    drawLine()
    // 画方块
    eShape.drawShape()
    drawList()
}

// 创建不再下落的俄罗斯方块
function createList() {
    for (var i = 0; i < 20; i++) {
        list[i] = []
        for (var j = 0; j < 10; j++) {
            list[i][j] = 0
        }
    }
}

// 存储不再下落的俄罗斯方块
function pushShapeToList() {
    for (var i = 0; i < eShape.layout.length; i++) {
        for (var j = 0; j < eShape.layout[0].length; j++) {
            if (eShape.layout[i][j] > 0) {
                list[Number(eShape.currentY + i)][Number(eShape.currentX + j)] = eShape.color + 1
            }
        }
    }
}
//把不再下落的俄罗斯方块画在画布上
function drawList() {
    for (var i = 0; i < list.length; i++) {
        for (var j = 0; j < list[i].length; j++) {
            if (list[i][j] != 0) {
                let listColorImg = getImage()
                gameContext.drawImage(listColorImg, c[Number(list[i][j] - 1)], 0, 20, 20, j * blockWidth, i * blockHeight, blockWidth, blockHeight)
            }
        }
    }
}


function changeLayout() {
    for (var i = 0; i < eShape.layout[0].length; i++) {
        newLayout[i] = []
        for (var j = 0; j < eShape.layout.length; j++) {
            newLayout[i][j] = eShape.layout[eShape.layout.length - j - 1][i]
            //eShape.layout = newLayout
        }
    }
    //变形后越界问题
    //记录变形后的坐标
    var offSetX = eShape.currentX + newLayout[0].length
    var offSetY = eShape.currentY + newLayout.length

    //方块原坐标
    var originX = eShape.currentX
    var originY = eShape.currentY

    if (offSetX > 10) {
        originX = 10 - newLayout[0].length
    }
    if (offSetY > 10) {
        originY = 20 - newLayout.length
    }

    //变形后是否会重叠
    for (var i = 0; i < newLayout.length; i++) {
        for (var j = 0; j < newLayout[0].length; j++) {
            if (newLayout[i][j] > 0 && list[originY + i][originX + j] > 0) {
                return
            }
        }
    }
    eShape.currentY = originX
    eShape.currentY = originY
    eShape.layout = newLayout
}

//消除最后一行
function clearList() {
    for (var i = list.length - 1; i > 0; i--) {
        var flag = true
        for (var j = 0; j < list[0].length; j++) {
            if (list[i][j] == 0) {
                flag = false
                break
            }
        }
        if (flag) {
            for (var x = i; x > 0; x--) {
                for (var y = 0; y < list[0].length; y++) {
                    list[x][y] = list[x - 1][y]
                }
            }
            sc += 20
            if(sc>=0){
                document.querySelector(".yellow").disabled=false
                percentage.innerHTML= 100 + "%"
                progress.style.height = sc*2+ "px"
            }else {

                percentage.innerHTML= sc + "%"
                progress.style.height = sc*2+ "px"
            }
            number += 100
            document.querySelector(".score").innerHTML = '等分：' + number
            console.log(sc)
            i++
        }
    }
}
function superTime(){
    percentage.innerHTML = "0%"
    progress.style.height = "10px"
    sc = 0
    for(var i = 0;i<list[0].length;i++) {
        if(list[list.length-1][i] === 0){
            list[list.length-1][i]=1
        }
    }    
    document.querySelector(".yellow").style.backgroundColor = "rgb(179, 179, 179)"
    document.querySelector(".yellow").disabled=true
    document.querySelector(".yellow").onclick = function(){

    }
    
}