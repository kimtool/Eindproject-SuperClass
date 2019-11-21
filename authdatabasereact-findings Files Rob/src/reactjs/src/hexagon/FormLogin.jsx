import React, {useState, useRef} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button , Form } from 'react-bootstrap';

export default function FormLogin(){

    const formData = useRef(null);
    const query = new URLSearchParams(window.location.search);
    const error = query.has("error")
        ? "Wrong username or password"
        : "";
    const [result,setResult] = useState({});
    console.log("result", result);
    const handleSubmit = (event) => {
        event.preventDefault();
        let data = new FormData(formData.current);
        fetch(formData.current.action, {
            mode: 'no-cors',
            method: formData.current.method,
            body: new URLSearchParams(data)
        })
            .then(v => {
                setResult(v);
                if(v.redirected) window.location = v.url
            })
            .catch(e => console.warn(e))
    };

    return (
        <React.Fragment>
            <Form method="post" action="/login" onSubmit={handleSubmit} ref={formData}>
                <Form.Group controlId="error">
                    <Form.Label column={true}>{error}</Form.Label>
                </Form.Group>
                <Form.Group controlId="formBasicEmail">
                    <Form.Label column={true}>Email</Form.Label>
                    <Form.Control name="username" type="email" placeholder="Enter email" />
                    <Form.Text className="text-muted">
                        We'll never share your email with anyone else.
                    </Form.Text>
                </Form.Group>

                <Form.Group controlId="formBasicPassword">
                    <Form.Label column={true}>Password</Form.Label>
                    <Form.Control name="password" type="password" placeholder="Password" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Login
                </Button>
            </Form>
        </React.Fragment>
    )}
