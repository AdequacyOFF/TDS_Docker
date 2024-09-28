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
            #{project.project_id}
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
          <p className="Progress">
            {project.progress}%
          </p>
        </div>
      ))}
    </div>
  );
};

export default ProjectList;
