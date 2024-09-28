import React from "react";
import { Link } from 'react-router-dom';
import ProjectList from './ProjectList';  // Импортируем компонент списка проектов
import '../Pages_css/Profile.css';

function Profile() {
  return (
    <div className="Profile-wrapper">
      <div className='Profile_photo'>
        <img src="src/Images/Photo.png" alt="Profile" />
      </div>
      <div className="User_info">
        <p className="Name">Name Sername</p>
        <p className="ID">ID: ID</p>
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
        <ProjectList />  {/* Вставляем компонент ProjectList, который отобразит все проекты */}
      </div>
    </div>
  );
}

export default Profile;
