import '../Pages_css/Create.css';
import { Link } from 'react-router-dom';

function Create() {

  return (
    <div className='Create_wrapper'>
      <h2>СОЗДАТЬ ПРОЕКТ</h2>
      <p className='Name_project'>Название:</p>
      <p className='Description'>Описание:</p>
      <p className='Members'>Добавьте участников:</p>
      <form action="" className="Create_name">
        <input type="text" placeholder="Добавьте название проекта"/>
      </form>
      <form action="" className="Create_description">
        <p><textarea placeholder="Добавьте описание проекта"/></p>
      </form>
      <form action="" className="Create_members">
        <input type="text" placeholder="Добавьте участника по имени или ID"/>
      </form>
      <div className='Avatars'>
        <figure>
          <img src="src/Images/Avatar.png" alt="" />
          <figcaption>Владислав</figcaption>
        </figure>
      </div>
      <Link to='/Profile' className='Create_project_form'>
        <button className='Create_project_btn'>
          СОХРАНИТЬ
        </button>
      </Link>
    </div>
  )
}

export default Create
