import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
    BrowserRouter as Router,
    Link,
    Switch,
    Route
} from "react-router-dom";
import React from "react";
import CommunicationInitializerScreen from "./screen/CommunicationInitializerScreen";
import CommunicationDeleterScreen from "./screen/CommunicationDeleterScreen";
import Button from 'react-bootstrap/Button';
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import logo from './logo.svg';

export default class App extends React.Component {

    //TODO: add internationalization and own logo :<
    render() {
        return (
            <div className="App">
                <Router>
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
                                <Link to="/connectCommunication">
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
                    <Switch>
                        <Route path="/initializeCommunication">
                            <CommunicationInitializerScreen initialize={true}/>
                        </Route>
                        <Route path="/connectCommunication">
                            <CommunicationInitializerScreen/>
                        </Route>
                        <Route path="/deleteCommunication">
                            <CommunicationDeleterScreen/>
                        </Route>
                    </Switch>
                </Router>
            </div>
        );
    }
}