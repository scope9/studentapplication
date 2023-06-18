import React, {useEffect, useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button } from '@mui/material';

// Material UI Text Field
export default function Student() {
    const paperStyle={padding:'50px 20px', width:600,margin:'20px auto'}
    // Make this form control form need to add useState
    const[name,setName]=useState('')
    const[address,setAddress]=useState('')
    // this is for GET request. Here its an empty array and setting the students with the results 
    const[students,setStudents]=useState([])

    // HandleClick function
    const handleClick=(e)=>{
        // prevent default value
        e.preventDefault()
        const student={name,address}
        // print name and address in the console
        console.log(student)
        // fetch is like an ajax library where it can receive information in various formats, including JSON, XML, HTML, and text files
        fetch("http://localhost:8080/student/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            // stringify method converts javascript object to json string
            body: JSON.stringify(student)

        }).then(()=> {
            // once the student is added to the database the console will output with message in the console
            console.log("New Student added")
        })
    }

    // useEffect is a React Hook and used for the GET method
useEffect(()=> {
    // this will get all studentList
    fetch("http://localhost:8080/student/getAll")
    .then(res=>res.json())
    .then((result)=>{
        // set the Students with the result
        setStudents(result);
    })
},[])

  return (
    <Container>
        {/* Paper creates the box around TextField, elevation moves the position, and PaperStyle updates the padding, width, and margin */}
        <Paper elevation={3} style={paperStyle}>
            <h1>Add Student</h1>
            <Box
            component="form"
            sx={{
                '& > :not(style)': { m: 1,  },
            }}
            noValidate
            autoComplete="off"
            >
            <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth
            // name comes from the useState
            value={name}
            // when user writes a name it should trigger the event and setName. The value the user types will be saved here.
            onChange={(e)=>setName(e.target.value)}
            />
            <TextField id="outlined-basic" label="Student Address" variant="outlined" fullWidth 
            value={address}
            onChange={(e)=>setAddress(e.target.value)}
            />
            {/* Once user clicks the button it will send the user input in the database */}
            <Button variant="contained" onClick={handleClick}>Submit</Button>
            </Box>
            {/* GET Section */}
        </Paper>
        <h1>Students</h1>
        <Paper elevation={3} style={paperStyle}>
            {/* Map will display each student list and each student will be added inside the paper */}
                {students.map(student=>(
                    // Each student will be given this style.
                    <Paper elevation={6} style={{margin:'10px', padding:'15px', textAlign:"left"}} key={student.id}>
                        Id:{student.id}<br/>
                        Name:{student.name}<br/>
                        Address:{student.address}
                        </Paper>
                ))
}
        </Paper>

    </Container>
  );
}
