import React from 'react';
import {Container, Row, Col} from 'reactstrap';

const About = () => {
    return (
        <div>
            <Container className="mt-4">
                <Row>
                    <Col>
                        <h1>Mossol은 Amos 개인 잡동사니 창고입니다.</h1>
                        <p className="lead">Amos가 모아놓은 여러 잡동사니를 즐겨보세요. <br/>잡동사니를 즐기기 위해서는 Amos로부터 인증된 계정을 받아야합니다.</p>
                        <h2>Contact</h2>
                        <p className="lead">amos.doan@gmail.com</p>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};

export default About;