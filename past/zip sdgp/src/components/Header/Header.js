import React from 'react';
import {Navbar, Nav, NavDropdown, Container} from 'react-bootstrap';
import Button from '../Buttons/Button'
import './Header.scss'
import logo from '../../assets/img/brand/Logo.svg'
import { Link } from 'react-router-dom';



const Header = () => {
    return (
        <>
            <Navbar className="navbar-custom" collapaseOnSelect fixed="top" expand="lg">
                <Container>
                    <Navbar.Brand href="#">
                    <img
                        // src="../assets/img/brand/Logo.svg"
                        src={logo}
                        width="105px"
                        className="d-inline-block align-top"
                        alt="React Bootstrap logo"
                    />
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav>
                            <Link to="/">
                                <Nav.Link className="navLink" href="/">Home</Nav.Link> 
                            </Link> 
                            <NavDropdown className="navLink" title="Features" id="basic-nav-dropdown">
                                <Link to="/Features/VoiceToSign">
                                    <NavDropdown.Item href="#VoiceToSign">Voice to Sign</NavDropdown.Item>
                                </Link>
                                <Link to="/Features/SignToWord"> 
                                    <NavDropdown.Item href="#SignToWord">Sign to Word</NavDropdown.Item>
                                </Link> 
                                <Link to="/Features/WordToSign">
                                    <NavDropdown.Item href="#WordToSign">Words to Sign</NavDropdown.Item>
                                </Link> 
                                <NavDropdown.Divider />
                                <NavDropdown.Item href="#Features">Explore</NavDropdown.Item>
                            </NavDropdown>
                            <Link to="/Learning">
                                <Nav.Link className="navLink" href="#Learning">Learning</Nav.Link>
                            </Link>
                            <Link to="/Community">
                                <Nav.Link className="navLink" href="#Community">Community</Nav.Link>
                            </Link> 
                            <Nav.Link className="navLink" href="#AboutUs">About Us</Nav.Link>
                        </Nav>
                        <Button
                            buttonStyle='btn--outline'
                            buttonSize='btn--mobile'
                            //   onClick={closeMobileMenu}
                        >
                            SIGN UP
                        </Button>
                    </Navbar.Collapse>
                </Container>          
            </Navbar>
        </>
    )
}

export default Header;
