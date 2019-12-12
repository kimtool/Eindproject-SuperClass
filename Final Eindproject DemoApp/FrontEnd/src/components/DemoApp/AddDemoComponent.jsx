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
                alert("Please choose a mp3 file.");
                 //hier kom de fout melding
             }
    }

    return (
        <div className="container">
            <h2>Upload Form</h2>
            <form>
                <label>
                    File Title<br/>
                    <input className="form-control" type="text" value={trackname}
                           onChange={(e) => { setTrackname(e.target.value)}}
                           placeholder="Give a title to your track" />
                </label><br/>
                <label>
                    File<br/>
                    <input className="form-control" type="file" name="file" onChange={(e) => setFile(e.target.files[0])} />
                </label><br/>
                <label>
                   Description<br/>
                   <textarea className="form-control" value={description} onChange={(e) => setDescription(e.target.value)}></textarea>
                </label><br/>
                <input className="button" type="button" value="save" onClick={uploadWithFormData} />
                {/*<input type="button" value="Upload as JSON" onClick={uploadWithJSON}/>*/}
            </form>
        </div>
    );
}

export default AddDemoComponent;
