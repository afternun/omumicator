import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from "react-router-dom";
import React from "react";
import CommunicationInitializerScreen from "./screen/CommunicationInitializerScreen";
import HomeScreen from "./screen/HomeScreen";
import CommunicationDeleterScreen from "./screen/CommunicationDeleterScreen";

function App() {
    return (
        <Router>
            <Switch>
                <Route exact path="/" component={HomeScreen}/>
                <Route exact path="/initializeCommunication" component={CommunicationInitializerScreen}/>
                <Route exact path="/deleteCommunication" component={CommunicationDeleterScreen}/>
            </Switch>
        </Router>
    );
}

export default App;