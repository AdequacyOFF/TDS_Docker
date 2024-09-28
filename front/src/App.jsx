import {Route, Routes} from "react-router-dom"
import './App.css'
import Footer from './Pages/Footer.jsx'
import Header from './Pages/Header.jsx'
import Home from './Pages/Home.jsx'
import Profile from './Pages/Profile.jsx'
import Create from './Pages/Create.jsx'
import Register from './Pages/Register.jsx'
import ProjectDetail from './Pages/ProjectDetail.jsx';
import Pass from './Pages/Pass.jsx';
function App() {
  return (
  <div className='wrapper'>
    <header className='header'><Header></Header></header>
    <main className='main'>
            <Routes>
                <Route path="/" element={<Register />} />
                <Route path='/Home' element={<Home />}/>
                <Route path="/Profile" element={<Profile />} />
                <Route path="/Create" element={<Create />} />
                <Route path="/Pass" element={<Pass />} />
                <Route path="/project/:id" element={<ProjectDetail />} />
            </Routes>
    </main>
    <footer className='footer'>
        <Footer>
        </Footer>
      </footer>
  </div>
  )
}

export default App
