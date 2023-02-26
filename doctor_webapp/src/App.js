
import Pat from './components/PatientInfo'
import Nav from './components/Navbar_head'
import Login from './components/Login'
import Responses from './components/Responses'
import { Route, Router, Routes } from 'react-router-dom'
// Example of a data array that
// you might receive from an API

function App() {

  var reply =window.sessionStorage.getItem("isLoggedIn")
  var patient_response = window.sessionStorage.getItem("isResponse")
  return (
    // <>
    // <>
    
    // {reply === null && <Login />} 
    // {reply != null &&
    // (
    // <>
    // <Nav/>
    // <Pat/>
    
    // </>
    // )
    // }
    
   
    // </>
    <>
      <Nav/>
      <Routes>
        <Route path='/' element={<Login/>}/>
        <Route path='patient_details' element={<Pat />} />
        <Route path='patient_details/patient_responses' element={<Responses/>}/>
        
      </Routes>
    
    </>
  );
}
  
export default App;