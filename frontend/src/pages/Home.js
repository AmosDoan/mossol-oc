import React from 'react';
import {HashLink as Link} from 'react-router-hash-link';
import { Container, Jumbotron, Button } from 'reactstrap';

const Home = () => {
    return (
        <div>
            <Jumbotron>
                <h1 className="display-3">Mossol 시작하기</h1>
                <p className="lead">Internet이 연결된 모든 곳에서 Mossol을 시작하세요!</p>
                <p className="lead">
                    <Link to="/start#desktop_guide"><Button color="default">Desktop PC</Button></Link>{' '}
                    <Link to="/start#smartphone_guide"><Button color="primary">Android iOS</Button></Link>{' '}
                    <Link to="/start#smarttv_guide"><Button color="warning">Smart TV</Button></Link>{' '}
                </p>
            </Jumbotron>
            <Container>
                <h1>Mossol에 오신것을 환영합니다!</h1>
                <p className="lead">환영합니다!</p>
            </Container>
        </div>
    );
};

export default Home;