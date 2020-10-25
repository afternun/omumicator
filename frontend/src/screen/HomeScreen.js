import {
    Link
} from "react-router-dom";
import React from "react";
import Button from 'react-bootstrap/Button';
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import logo from '../logo.svg';
import Page from "../components/Page";

export default class HomeScreen extends React.Component {
    render() {
        return (
            <Page>
                <Container>
                    <Row>
                        <Col>
                            <img src={logo} className="App-logo" alt="logo"/>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <h1 className="color-white">OMUMICATOR</h1>
                        </Col>
                    </Row>

                    <Row className="margin-top">
                        <Col>
                            <Link to="/initializeCommunication">
                                <Button block>
                                    Initialize Communication
                                </Button>
                            </Link>
                        </Col>
                    </Row>

                    <Row className="margin-top">
                        <Col>
                            <Link to="/initializeCommunication">
                                <Button block>
                                    Connect To Communication
                                </Button>
                            </Link>
                        </Col>
                    </Row>

                    <Row className="margin-top">
                        <Col>
                            <Link to="/deleteCommunication">
                                <Button block>
                                    Delete Communication
                                </Button>
                            </Link>
                        </Col>
                    </Row>
                </Container>
            </Page>
        );
    }
}

