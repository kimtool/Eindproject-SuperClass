import React, {useState} from 'react'
import '../../App.css'
import axios from 'axios';
import {API_URL} from "../../Constants"
import AuthenticationService from "./AuthenticationService";
const username = AuthenticationService.getLoggedInUsername();

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
    }).catch((error) => {
        setResponse("error");
    })
}

function AddDemoComponent() {
    const [title, setTitle] = useState("");
    const [file, setFile] = useState(null);
    const [description, setDescription] = useState("");

    function uploadWithFormData(){
        const formData = new FormData();
        formData.append("title", title);
        formData.append("file", file);
        // formData.append("desc", desc);

        submitForm("", formData, (msg) => console.log(msg));
    }

    return (
        <div className="App">
            <h2>Upload Form</h2>
            <form>
                <label>
                    File Title<br/>
                    <input type="text" value={title}
                           onChange={(e) => { setTitle(e.target.value )}}
                           placeholder="Give a title to your track" />
                </label><br/>
                <label>
                    File<br/>
                    <input type="file" name="file" onChange={(e) => setFile(e.target.file)} />
                </label><br/>
                <label>
                   Description<br/>
                   <textarea value={description} onChange={(e) => setDescription(e.target.value)}></textarea>
                </label><br/>
                <input type="button" value="Upload as Form" onClick={uploadWithFormData} />
                {/*<input type="button" value="Upload as JSON" onClick={uploadWithJSON}/>*/}
            </form>
        </div>
    );
}

export default AddDemoComponent;