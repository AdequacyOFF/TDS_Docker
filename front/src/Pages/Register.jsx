import '../Pages_css/Register.css';
import React from "react";
import {Link} from "react-router-dom"


function Register() {

  return (
    <div className="section">
      <form className='answer-txt'>
        <h1>РЕГИСТРАЦИЯ</h1>
        <div className="registrationField">
          <input type="text" placeholder="Фамилия" />
          <input type="text" placeholder="Имя" />
          <input type="text" placeholder="Отчество" />
          <input type="text" placeholder="Почта" />
          <input type="password" placeholder="Пароль" minlength="8" required/>
          <input type="password" placeholder="Повторить пароль" minlength="8" required/>
        </div>
        <Link to='/Home'><button className='registerBtn'>ЗАРЕГЕСТРИРОВАТЬСЯ</button></Link>
      </form>
    </div>
  );
};

export default Register;