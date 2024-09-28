import React, { useState, useEffect } from "react";
import { Link } from 'react-router-dom';
import ProjectList from './ProjectList';
import '../Pages_css/Profile.css';

function Profile() {
  const [userData, setUserData] = useState({ login: "", id: "" });

  useEffect(() => {
    const cachedUserId = localStorage.getItem('userId') || sessionStorage.getItem('userId');

    if (cachedUserId) {
      fetch(`http://localhost:8080/api/user/profile`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ id: cachedUserId }),
      })
        .then(response => response.json())
        .then(data => {
          if (data.id && data.login) {
            setUserData({ name: data.login, id: data.id });
          } else {
            console.error("Ошибка при получении данных пользователя:", data);
          }
        })
        .catch(error => {
          console.error("Ошибка при подключении к серверу:", error);
        });
    } else {
      console.error("ID пользователя не найдено в localStorage или sessionStorage");
    }
  }, []);

  return (
    <div className="Profile-wrapper">
      <div className='Profile_photo'>
        <img src="src/Images/Photo.png" alt="Profile" />
      </div>
      <div className="User_info">
        <p className="Name">{userData.login}</p> 
        <p className="ID">ID: {userData.id}</p> 
      </div>
      <div className="Project_buttons">
        <Link to='/Create'><button> СОЗДАТЬ ПРОЕКТ</button></Link>
      </div>
      <div className="Search">
        <form action="">
          <input type="text" placeholder="Присоединиться к проекту через название или #" />
        </form>
      </div>
      <div className="Projects">
        <h1>Мои проекты</h1>
        <ProjectList />  
      </div>
    </div>
  );
}

export default Profile;
