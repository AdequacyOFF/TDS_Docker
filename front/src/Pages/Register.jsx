import "../Pages_css/Register.css";
import React, { useState } from "react";
import { Link } from "react-router-dom";

function Register() {
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [userId, setUserId] = useState(null);

  const handleLogin = (event) => {
    event.preventDefault();
    fetch("http://localhost:8080/api/user/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ login, password }),
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.id) {
          console.log("User ID:", data.id);
          setUserId(data.id);
        } else {
          console.error("Login failed:", data);
        }
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <div className="section">
      <form className="answer-txt" onSubmit={handleLogin}>
        <h1>ВХОД</h1>
        <div className="registrationField">
          <input
            type="text"
            placeholder="Логин"
            value={login}
            onChange={(e) => setLogin(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Пароль"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            minLength="8"
            required
          />
        </div>
        <button className="registerBtn" type="submit">
          ВОЙТИ
        </button>
      </form>
      {userId && <Link to="/Home">Перейти на домашнюю страницу</Link>}
    </div>
  );
}

export default Register;