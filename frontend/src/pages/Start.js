import React from 'react';
import {HashLink as Link} from 'react-router-hash-link';
import {Jumbotron, Button, Row, Col, Container} from 'reactstrap';

const Start = () => {
    //https://stackoverflow.com/questions/48223566/using-anchor-tags-in-react-router-4
    return (
        <div>
            <div>
                <Jumbotron>
                    <Container>
                        <h1 className="display-3">Mossol 시작하기</h1>
                        <p className="lead">Internet이 연결된 모든 곳에서 Mossol을 시작하세요!</p>
                        <p className="lead">
                            <Link to="/start#desktop_guide"><Button color="default">Desktop PC</Button></Link>{' '}
                            <Link to="/start#smartphone_guide"><Button color="primary">Android iOS</Button></Link>{' '}
                            <Link to="/start#smarttv_guide"><Button color="warning">Smart TV</Button></Link>{' '}
                        </p>
                    </Container>
                </Jumbotron>
            </div>
            <Container>
                <Row>
                    <Col>
                        <div>
                            <h1><a id="desktop_guide">Desktop PC</a></h1>
                        </div>
                        <p className="lead">상기 페이지의 Content 메뉴를 이용하세요</p>


                        <div className="page-header">
                            <h1><a id="smartphone_guide">Android / iOS</a></h1>
                        </div>
                        <p className="lead">스마트 폰 및 태블릿에서는 DS Series App을 이용하여 Mossol 컨텐츠를 즐길 수 있습니다.</p>
                        <div className="page-header">
                            <h2>Android</h2>
                            <ul>
                                <li>Google Store에서 DS Video, DS Audio를 겁색하면, 최신버전을 이용하실 수 있습니다.</li>
                                <li>Samsung Galaxy 등 일부 안드로이드 기기에서는 기본 동영상 플레이어로 재생이 불가할 수 있습니다. Mx Player와 같은 서드파티 동영상 플레이어를
                                    설치해주세요
                                </li>
                            </ul>
                        </div>
                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>App Name</th>
                                <th>Link</th>
                                <th>Description</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>DS Video for Android</td>
                                <td><a href="https://play.google.com/store/apps/details?id=com.synology.dsvideo&hl=ko"
                                       target="_blank">DS Video</a></td>
                                <td>Mossol에서 제공하는 Video Contents 감상</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>DS Audio for Android</td>
                                <td><a href="https://play.google.com/store/apps/details?id=com.synology.DSaudio&hl=ko"
                                       target="_blank">DS Audio</a></td>
                                <td>Mossol에서 제공하는 Audio Contents 감상</td>
                            </tr>
                            </tbody>
                        </table>

                        <div className="page-header">
                            <h2>iOS</h2>
                            <ul>
                                <li>App Store에서 DS Video, DS Audio를 겁색하면, 최신버전을 이용하실 수 있습니다.</li>
                            </ul>
                        </div>

                        <table className="table table-striped">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>App Name</th>
                                <th>Link</th>
                                <th>Description</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>DS Video for iPhone</td>
                                <td><a href="https://itunes.apple.com/kr/app/ds-video/id540949418?mt=8" target="_blank">DS Video</a>
                                </td>
                                <td>Mossol에서 제공하는 Video Contents 감상</td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>DS Audio for iPhone</td>
                                <td><a href="https://itunes.apple.com/kr/app/ds-audio/id321495303?mt=8" target="_blank">DS Audio</a>
                                </td>
                                <td>Mossol에서 제공하는 Audio Contents 감상</td>
                            </tr>
                            </tbody>
                        </table>

                        <div className="page-header">
                            <h2>App.을 다운받은 후</h2>
                            <ul>
                                <li>주소에 mossol.net을 입력합니다.</li>
                                <li>Amos로부터 받은 계정 정보를 입력합니다.</li>
                                <li>HTTPS 항목을 체크해제합니다.</li>
                            </ul>
                        </div>

                        <div className="page-header">
                            <h1><a id="smarttv_guide">Smart TV</a></h1>
                            <ul>
                                <li>Samsung Smart TV의 경우 Samsung App Store에서 DS Video, DS Audio를 겁색하면, 최신버전을 이용하실 수 있습니다.</li>
                            </ul>
                        </div>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};

export default Start;