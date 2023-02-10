let x = document.getElementById('errol').textContent;
console.log(x);
console.log(x.length)
console.log(x.name )
if(x.length === 78 || x.length === 76){
    document.getElementById('errol').style.display = "none";
}else {
console.log('3');
    document.getElementById('errol').style.display = "block";
}



function validateEmail() {
    let regexEmail = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    let email = document.forms["forgotPass"]["email"].value;
    if (email.match(regexEmail)) {
        return true;
    } else {
        let er = document.getElementById('errol');
        er.style.display = "block"; 
        er.innerHTML = "Opps :(( Invalid Email ! Please Re-Enter Email ";     
        return false;
    }
}

function validateChangePass() {
     let newpass = document.forms["changePass"]["newPassword"].value;
     let cfnewpass = document.forms["changePass"]["cfnewPassword"].value;

    if(cfnewPassword.localeCompa(renewpass) == 0){
       alert(1) ;
        return true;
     }
     alert(2) ;
     let er = document.getElementById('errol');
     er.style.display = "block"; 
     er.innerHTML = "New Password and Re-password is not correct ! ";     
     return false;
     
} 