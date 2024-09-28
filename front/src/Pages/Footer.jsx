import Cooperation from './Cooperation';
import Logo from './Logo';
import Contacts from './Contacts';
import '../Pages_css/Footer.css';

function Footer() {

  return (
    <div className='Footer'>
        <Logo/>
        <Cooperation/>
        <hr className='Strip'></hr>
      <Contacts/>
    </div>
  )
}

export default Footer
