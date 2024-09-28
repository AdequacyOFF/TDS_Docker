import { Link } from 'react-router-dom';
import '../Pages_css/Header.css';
import Logo from "../assets/TDSLogo.png";

function Header() {

  return (
    <div className='Head'>
      <Link to='/Profile' className='Profile_logo' title=''><img src="src/Images/Profile.png" alt=""  className='Profile_logo' />
      <div class="dropdown-content">
          <Link to='/Profile' className='Profile_links'>Profile</Link>
          <Link to='/' className='Profile_links'>Home</Link>
        </div>
      </Link>
      <Link to='/' className='Logo' title=''><img src={Logo} alt="" className='Logo'/></Link>
      <p className='TDS'>
        <p className='TDS_b'>T</p>
        ask
        <p className='TDS_b'> D</p>
        istribution   
        <p className='TDS_b'> S</p>
        ystem
      </p>
    </div>
  )
}

export default Header
