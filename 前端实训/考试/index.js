var checkBoxes
window.onload = function(){
    checkBoxes = document.querySelectorAll('#check')
    for(var i =1;i<checkBoxes.length;i++){
        checkBoxes[i].onclick = function(){
            if(isAllCheacked()){
                checkBoxes[0].checked = true 
            }else {
                checkBoxes[0].checked = false 
            }
        }
    }
    checkBoxes[0].onclick = function(){
        if(checkBoxes[0].checked = true){
            xall()
        }else {
            nall()
        }

    }
}


function xall() {
    for(var i=0;i<checkBoxes.length;i++)
    {

        checkBoxes[i].checked=true;
    }
}
function nall() {
    for(var i=0;i<checkBoxes.length;i++)
    {
        checkBoxes[i].checked=false;
    }
}
function fall() {
    for(var i=0;i<checkBoxes.length;i++)
    {
        if(checkBoxes[i].checked == true)
        {
            checkBoxes[i].checked = false; 
        }
        else
        {
            checkBoxes[i].checked = true;
        }
    }
}
function isAllCheacked(){
    for(var i =1;i<checkBoxes.length;i++){
        if(checkBoxes[i].checked == false){
            return
        }
    }
    return true
}