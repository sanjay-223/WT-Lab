function validate()
{
    const name=document.f.name.value;
    const email=document.f.email.value;
    const phno = document.f.phno.value;
    const pass=document.f.pass.value;
    //console.log(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g.test(email));
    if (name == '' || /\d+$/g.test(name))
    {
        window.alert('Enter your name properly');
        return false;
    }

    if(email == '' ||  ! (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/g.test(email)))
    {
        
        window.alert("Enter email correctly");
        return false;
    }
    
    if(phno == "" || /^\d{10}$/.test(phno))
    {
        window.alert("enter Ph No. Correctly");
        return false;
    }

    if(pass == '' || pass.length < 6)
    {
        window.alert("Password should be atleast 6 char"); 
        return false;

    }
    return true;
}