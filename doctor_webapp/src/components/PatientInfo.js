import "../PatientInfo.css";
import Button from "react-bootstrap/Button";
import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link, useNavigate,  } from "react-router-dom";

// Example of a data array that
// you might receive from an API
// const data = [
//   { id: 1, name: "John", age: 23, gender: "Male", phone: 123456789, status: 1 },
//   { id: 2, name: "Tom", age: 23, gender: "Male", phone: 123456789, status: 1 },
//   { id: 3, name: "Billy", age: 19, gender: "Male", phone: 123456789, status: 1 },
// ];

export default function PatientInfo() {
  const navigate = useNavigate()
  // const [data, setData] = useState();

  // console.log(data[0].status)
  const[res,setRes]=useState([]);
  // https://d1da-119-161-98-68.in.ngrok.io/doctor/patient/1
  // http://localhost:8080/doctor/patient/1
  const Fetch_data = async()=>{
    await axios.get(`https://0d46-103-156-19-229.in.ngrok.io/doctor/patient/1`)
    .then((response)=>{
        console.log(response.data);
        setRes(response.data);
    })
    .catch(function(error)
    {
        console.log(error);
    });
    
}

useEffect(()=>{
    Fetch_data();
},[]);



  const handleRetrieve = (id, status) => {
    //It will go to next page and display the patient responses.
    
  };

  
  
  return (
    <>
    <div>
      
    </div>
      <div>
        <div className="table-responsive">
          <table className="table table-striped">
            <thead>
              <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                {/* <th>Age</th> */}
                <th>Gender</th>
                <th>Phone No.</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              {res.map((val, key) => {
                return (
                  <tr key={key}>
                    <td>{val.patient_id}</td>
                    <td>{val.firstName}</td>
                    <td>{val.lastName}</td>
                    {/* <td>{val.age}</td> */}
                    <td>{val.gender}</td>
                    <td>{val.contact_number}</td>
                    <td>
                      <Button
                        type="click"
                        variant="primary"
                        onClick={()=>navigate('patient_responses',{state: { patient_id:val.patient_id,firstName:val.firstName,gender:val.gender,remarks:val.remarks}})}>
                        Retrieve
                      </Button>
                    </td>
                    <td>
                      <Button
                        type="click"
                        variant="primary"
                       >
                        Modify Workout
                      </Button>
                    </td>
                  </tr> 
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
}
