// 定义俄罗斯方块的形状
// var layouts = [
//     [
//         [1, 1, 1, 1]
//     ],
//     [
//         [1, 1],
//         [1, 1]
//     ],
//     [
//         [0, 1, 0],
//         [1, 1, 1]
//     ],
//     [
//         [1, 1, 0],
//         [0, 1, 1]
//     ],
//     [
//         [0, 1, 1],
//         [1, 1, 0]
//     ],
//     [
//         [1, 0, 0],
//         [1, 1, 1]
//     ],
//     [
//         [0, 0, 1],
//         [1, 1, 1]
//     ]
// ]
var layouts = [
    [
        [1, 1, 1, 1]
    ],
    [
        [1, 1, 1, 1]
    ],
    [
        [1, 1, 1, 1]
    ],
    [
        [1, 1, 1, 1]
    ],
    [
        [1, 1, 1, 1]
    ],
    [
        [1, 1, 1, 1]
    ],
    [
        [1, 1, 1, 1]
    ]
]
var gameCanvas = document.querySelector('#gameCanvas')
var gameContext = gameCanvas.getContext("2d")
var nextCanvas = document.querySelector('#nextCanvas')
var nextContext = nextCanvas.getContext("2d")
var c = [0, 20, 40, 60, 80, 100, 120]
var eShape; //eShape代表了一个俄罗斯方块
var nextShape; //下一个俄罗斯方块


var blockWidth, blockHeight //每个方格的长宽
var list = []
var copyList = []
var buttomIndex = 20 //最低下的标号

blockWidth = window.innerWidth * 0.6 / 10
blockHeight = blockWidth
// 设置画布的宽度和高度
gameCanvas.width = blockWidth * 10
gameCanvas.height = blockHeight * 20
nextCanvas.width = blockWidth * 4
nextCanvas.height = blockHeight * 2


function copyLists() {
    for (var i = 0; i < list.length; i++) {
        for (var j = 0; j < list[i].length; j++) {
            copyList[i][j] = list[i][j]
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

function isMove(y) {
    var nextY = eShape.currentY + y
    if (nextY > 20 - eShape.layout.length) {
        // console.log(buttomIndex)
        // if (nextY >= buttomIndex) {
        return false
    } else {
        copyLists()
        pushShapeToCopyList()
        console.log(copyList)
        if (copyList[eShape.currentX][eShape.currentY] > 0 && copyList[eShape.currentX][eShape.currentY + 1] > 0) {
            return false
        }
        return true
    }
}
createList()
createCopyList()

function getImage() {
    var img = new Image()
    img.src = "../source/img/blocks1.png"
    return img
}
eShape = new Shape()
nextShape = new NextShape()

eShape.img.onload = function () {

    setInterval(() => {
        move()
    }, 500);
}
nextShape.img.onload = function () {
    nextShape.updateFrame()
    nextShape.drawNextShape()
}


function move() {
    // 方块的下落
    if (isMove(1)) {
        eShape.currentY += 1
    } else {
        // 重置俄罗斯方块并把下一个俄罗斯方块的信息赋给俄罗斯方块
        pushShapeToList()
        eShape.currentX = 3
        eShape.currentY = 0
        eShape.color = nextShape.color
        eShape.layout = nextShape.layout
        // 生成下一个俄罗斯方块
        nextShape.updateFrame()
        nextContext.clearRect(0, 0, nextCanvas.width, nextCanvas.height)
        nextShape.drawNextShape()

        drawList()
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
    //drawArr()
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

function createCopyList() {
    for (var i = 0; i < 20; i++) {
        copyList[i] = []
        for (var j = 0; j < 10; j++) {
            copyList[i][j] = 0
        }
    }
}
// 存储不再下落的俄罗斯方块
function pushShapeToList() {
    for (var i = 0; i < eShape.layout.length; i++) {
        for (var j = 0; j < eShape.layout[0].length; j++) {
            if (eShape.layout[i][j] > 0) {
                list[Number(eShape.currentY + i)][Number(eShape.currentX + j)] = eShape.color + 1
                //list[][] = eShape.color + 1
            }
        }
    }
}
// 存储正在下落的俄罗斯方块
function pushShapeToCopyList() {
    for (var i = 0; i < eShape.layout.length; i++) {
        for (var j = 0; j < eShape.layout[0].length; j++) {
            if (eShape.layout[i][j] > 0) {
                copyList[eShape.currentY + j][eShape.currentX + i] = eShape.color
            }
        }
    }
}
//把不再下落的俄罗斯方块画在画布上
function drawList() {

    for (var i = 0; i < list.length; i++) {
        for (var j = 0; j < list[i].length; j++) {
            if (list[i][j] != 0) {
                if (buttomIndex > i) {
                    buttomIndex = i
                }
                let listColorImg = getImage()
                gameContext.drawImage(listColorImg, c[Number(list[i][j] - 1)], 0, 20, 20, j * blockWidth, i * blockHeight, blockWidth, blockHeight)
            }
        }
    }
}