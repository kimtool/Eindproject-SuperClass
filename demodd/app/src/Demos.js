import AppNavbar from './AppNavbar';
import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';

const API_BASE = "http://localhost:8080"

function submitForm(contentType, data, setResponse) {
    axios({
        url: `${API_BASE}/api/files`,
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

function Demos() {
    const [trackname, setTreackname] = useState("");
    const [file, setFile] = useState(null);
    const [desc, setDesc] = useState("");

    function uploadWithFormData(){
        const formData = new FormData();
        formData.append("trackname", trackname);
        formData.append("file", file);
        // formData.append("desc", desc);

        submitForm("multipart/form-data", formData, (msg) => console.log(msg));
    }

    // async function uploadWithJSON(){
    //     const toBase64 = file => new Promise((resolve, reject) => {
    //         const reader = new FileReader();
    //         reader.readAsDataURL(file);
    //         reader.onload = () => resolve(reader.result);
    //         reader.onerror = error => reject(error);
    //     });
    //
    //     const data = {
    //         title: trackname,
    //         file: await toBase64(file),
    //         desc: desc
    //     }
    //
    //     submitForm("application/json", data, (msg) => console.log(msg));
    // }

    return (
        <div className="App">
            <AppNavbar/>
            <h2>Upload Form</h2>
            <form>
                <label>
                    File Title<br/>
                    <input type="text" value={trackname}
                           onChange={(e) => { setTreackname(e.target.value )}}
                           placeholder="Give a title to your track" />
                </label><br/>

                <label>
                    File<br/>
                    <input type="file" name="file" onChange={(e) => setFile(e.target.files[0])} />
                </label><br/>

                {/*<label>*/}
                {/*    Description<br/>*/}
                {/*    <textarea value={desc} onChange={(e) => setDesc(e.target.value)}></textarea>*/}
                {/*</label><br/>*/}

                <input type="button" value="Upload as Form" onClick={uploadWithFormData} />
                {/*<input type="button" value="Upload as JSON" onClick={uploadWithJSON}/>*/}
            </form>
        </div>
    );
}

export default Demos;
