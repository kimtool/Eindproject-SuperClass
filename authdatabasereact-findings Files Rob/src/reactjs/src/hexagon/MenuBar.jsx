import React, {useState} from 'react';
import { Link} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Navbar, Nav, Button, Container, Row,Col} from 'react-bootstrap';
import logo from "./hexagon.png";


export default function MenuBar(Props) {

    const leftMenuLinks = Props.authenticated
        ?[{ link:"/editprofile",
            name: "Edit Profile"},
            { link:"/profile",
                name: "Profile"},
            { link:"/dropdemo",
                name: "Drop Demo"}]
        :[];
    const rightMenuLinks = Props.authenticated
    ? [{link:"/logout",
        name: "Logout"}]
    :  [];
    var styles1 = {
        width: '350px',
    };
    return(
        <React.Fragment>

            <Navbar fixed="top" bg="dark" variant="dark">
                <Nav className="mr-auto">
                    {leftMenuLinks.map((item,index) => <Nav.Link key={index} as={Link} to={item.link}>{item.name}</Nav.Link>)}
                 </Nav>
                <Container style={styles1}>
                    <Col><Navbar.Text>HEXAGON</Navbar.Text></Col>
                        <Col><Navbar.Brand as={Link} to="/">
                            <img
                                src={logo.toString()}
                                width="30"
                                height="30"
                            />
                        </Navbar.Brand></Col>
                        <Col><Navbar.Text>Demo Drop</Navbar.Text></Col>
                </Container>

                {rightMenuLinks.map((item,index) => <Button href={item.link}>{item.name}</Button>)}
            </Navbar>

        </React.Fragment>
    )
}