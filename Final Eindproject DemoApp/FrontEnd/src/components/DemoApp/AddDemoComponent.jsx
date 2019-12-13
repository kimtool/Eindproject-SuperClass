import React, {useState} from 'react'
import { useHistory } from "react-router-dom";
import '../../App.css'
import axios from 'axios';
import {API_URL} from "../../Constants"
import AuthenticationService from "./AuthenticationService";
const username = AuthenticationService.getLoggedInUsername();

function AddDemoComponent() {

    let history = useHistory();


function submitForm(contentType, data, setResponse) {    
    axios({
        url: `${API_URL}/users/${username}/demos`,
        method: 'POST',
        data: data,
        headers: {
            'Content-Type': contentType
        }
    }).then((response) => {
        setResponse(response.data);
        history.push("/demos")  
    }).catch((error) => {
        setResponse("error");
    })
}    

    const [trackname, setTrackname] = useState("");
    const [file, setFile] = useState(null);
    const [description, setDescription] = useState("");
    const [fileInput, setFileInput] = useState("Choose Demo");

    function uploadWithFormData(){
        const fi = file.type;
             if(fi === "audio/mp3"){
                 console.log("het is " + fi);
        const formData = new FormData();
        formData.append("trackname", trackname);
        formData.append("file", file);
        formData.append("username", username);
        formData.append("description", description);
        // formData.append("desc", desc);

        submitForm("multipart/form-data", formData, (msg) => console.log(msg))       
             }else{
                 //hier kom de fout melding
             }
    }
    function inputChanged(e){
        setFile(e.target.files[0]);
        setFileInput("Demo succesfully selected!");
    }

    return (
        <div>
            <h2 className="title">Upload Form</h2>
            <form id="register_block">
            <div id="fields">
                <label >
                    <input className="form-control" type="text" value={trackname}
                           onChange={(e) => { setTrackname(e.target.value)}}
                           placeholder="Title" style={{width:"400px"}}/>                    
                </label>
                <div className="custom-file">
                    <input type="file" className="custom-file-input" name="file" onChange={(e) => inputChanged(e)}/>
                    <label id="inputFile" className="custom-file-label" for="inputGroupFile01">{fileInput}</label>
                </div>
                {/* <label>Choose a file</label>
                    <input className="form-control" type="file" name="file"  onChange={(e) => setFile(e.target.files[0])}/> */}
                <label style={{marginTop:"24px"}}>
                   <textarea className="form-control" value={description} onChange={(e) => setDescription(e.target.value)}
                   placeholder="Description" ></textarea>
                </label>
                <input className="button" type="button" value="save" onClick={uploadWithFormData} />
                {/*<input type="button" value="Upload as JSON" onClick={uploadWithJSON}/>*/}
                </div>
            </form>
        </div>
    );
}

export default AddDemoComponent;
