import "../Pages_css/Register.css";
import React, { useState } from "react";
import { Link } from "react-router-dom";

function Register() {
  const [login, setLogin] = useState("");
  const [password, setPassword] = useState("");
  const [userId, setUserId] = useState(() => localStorage.getItem('userId'));

  const handleLogin = (event) => {
    event.preventDefault(); // Prevent default form submission
    fetch("http://localhost:8080/api/user/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ login, password }), // Send login and password as JSON
    })
      .then((response) => response.json())
      .then((data) => {
        if (data.id) {
          console.log("User ID:", data.id); // Log the user ID
          localStorage.setItem('userId', data.id); // Cache the user ID in localStorage
          setUserId(data.id); // Update the userId state
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
      <h1>ВХОД</h1>
      <form id="signin" onSubmit={handleLogin}>
        <div  id='wrapper'>
          <input
            type="text"
            placeholder="Логин"
            value={login}
            onChange={(e) => setLogin(e.target.value)}
            required
            id="user"
          />
          <input
            type="password"
            placeholder="Пароль"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            minLength="8"
            required
            id="pass"
          />
        </div>
        <button  type="submit">
        &#xf0da;
        </button>
      </form>

      {/* Conditionally render the Link component if userId is set */}
      {userId && <Link to="/Home">Перейти на домашнюю страницу</Link>}
    </div>
    
  );
}

export default Register;