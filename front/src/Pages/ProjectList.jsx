import React from 'react';
import { useNavigate, Link } from 'react-router-dom';
import projects from './projects.json';
import '../Pages_css/ProjectList.css'; 

const ProjectList = () => {
  const navigate = useNavigate();

  return (
    <div>
      {projects.map((project) => (
        <div key={project.project_id} className="project-card">
          <p className="Project_name">
            {project.project_name}
            <br />
            <p className='Hesh'>
              #{project.project_id}
            </p>
          </p>
          <p className="GM_info">
            <p className="GM">
              Руководитель:  
              <Link to="/Profile" className="lead-name">{project.lead_name}</Link>
            <br />
              Текущее:
            </p>
          </p>
          <p className="Manage_project">
            <button onClick={() => navigate(`/project/${project.project_id}`)}>Управлять проектом</button>
          </p>
          <div className="Progress">
            <p>
              {project.progress}%
            </p>
          </div>
        </div>
      ))}
    </div>
  );
};

export default ProjectList;
