/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    alert("");
    getData();
});

function getData(){
    $.ajax({
       url: "rest/web",
       async:false
              
    }).done(function(data){
        alert(data);
    });
}
