import React from 'react'
import {Row, Col, Container} from 'react-bootstrap'
import './LandviewSection.scss'
import img from '../../assets/img/—Pngtree—deaf-mute people communicate better than_5918374.png'

export const LandviewSection = () => {
    return (
        <div className="landSectionBg">
            <Container className="landSection">
                <Row className="text-sm-center">
                    <Col className="text-lg-center" sm={12} lg={7}>
                        <h1 className="Headline"><span className="Headline Sinhala">isxy,</span> Sign language Communication platform</h1>
                        <p className="SubHeader">We help you to learn Sinhala sign language and communicate through signs or convert your thought into signs.</p>
                    </Col>
                    <Col lg={5} sm={12}>
                    <img
                        width="589px"
                        src={img}
                        className="d-inline-block align-top main-img"
                        alt="Talking"
                    />
                    </Col>
                </Row>
            </Container>
        </div>
    )
}

export default LandviewSection;
