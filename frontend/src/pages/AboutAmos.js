import React from 'react';
import {Col, Container, Jumbotron, Row} from 'reactstrap';
import {GiGraduateCap} from 'react-icons/gi';
import {GoOrganization} from "react-icons/go";
import {SocialIcon} from 'react-social-icons'
import ProfileImage from '../img/profile.png';


const AboutAmos = () => {
    return (
        <div>
            <Jumbotron>
                <Container>
                    <Row>
                        <Col sm="4" className="mr-3" >
                            <img src={ProfileImage} width="128" className="float-left mr-3 img-fluid img-profile rounded-circle d-inline-block"/>
                            <h1 className="display-5">Dohan Kim</h1>
                            <p className="lead">SEOUL REPUBLIC OF KOREA</p>
                            <SocialIcon url="mailto:amos.doan@gmail.com" style={{ marginRight : 5}} className="mb-2"/>
                            <SocialIcon url="https://www.linkedin.com/in/dohan-kim-099156143/" style={{ marginRight : 5}} className="mb-2"/>
                            <SocialIcon url="https://www.facebook.com/zellato" style={{ marginRight : 5}} className="mb-2"/>
                            <SocialIcon url="https://github.com/AmosDoan?tab=repositories" style={{ marginRight : 5}} className="mb-2"/>
                            <SocialIcon url="https://www.instagram.com/amos_doan/" style={{ marginRight : 5}} className="mb-2"/>
                        </Col>
                        <Col sm="7">
                            <p className="lead">
                                I'm currently working at <strong>LINE Corp.</strong> My main role is developing & maintaining LINE messenger server.
                                I've joined this company from May 8th 2017. At the previous company, <strong>TmaxData</strong>, I developed the desktop OS known as TmaxOS and developed Cloud Desktop Service
                            </p>
                        </Col>
                    </Row>
                </Container>
            </Jumbotron>
            <Container className="mb-5">
                <Row className="mt-5">
                    <Col>
                        <Row>
                            <h1>Experience & Skills <GoOrganization/></h1>
                        </Row>
                        <Row className="mt-4">
                            <Col>
                                <a href="https://linecorp.com/"><h4>LINE CORPORATION</h4></a>
                                <p>May 2017 - Now</p>
                            </Col>
                            <Col>
                                <ul>
                                    <li>Develop & maintain messaging server</li>
                                    <li>Develop LINE messenger new feature</li>
                                    <li>JAVA / Spring Framework / Kafka</li>
                                </ul>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <a href="https://www.tmaxdata.com/"><h4>TMAXDATA</h4></a>
                                <p>Mar. 2015 -  May 2017</p>
                            </Col>
                            <Col>
                                <ul>
                                    <li>Develop TmaxOS installer & initial configuration</li>
                                    <li>Develop TmaxOS image generator</li>
                                    <li>Develop TmaxOS CDS server & client</li>
                                    <li>C / C++ (C++11)  / Shell scripting</li>
                                </ul>
                            </Col>
                        </Row>
                    </Col>
                </Row>
                <Row className="mt-4">
                    <h1>Education <GiGraduateCap/></h1>
                </Row>
                <Row>
                    <Col>
                        <a href="http://cse.snu.ac.kr"><h4>SEOUL NATIONAL UNIVERSITY</h4></a>
                        <p>Jan. 2013 - Mar. 2015</p>
                    </Col>
                    <Col>
                        <p className="lead">I received M.S. in Computer Science & Engineering at Seoul National University. My research area was embedded-system, more specifically power optimization on Android system</p>
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <a href="http://icc.skku.ac.kr"><h4>SUNGKYUNKWAN UNIVERSITY</h4></a>
                        <p>Mar. 2008 - Mar. 2013</p>
                    </Col>
                    <Col>
                        <p className="lead">I received B.S. in Electrical & Electronic Engineering at Sungkyunkwan University. </p>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};

export default AboutAmos;