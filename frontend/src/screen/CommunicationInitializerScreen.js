import React from "react";
import Page from "../components/Page";

export default class CommunicationInitializerScreen extends React.Component {
    render() {
        return <Page>
            <div>{this.props.initialize ? "INITIALIZE" : "CONNECT"}</div>
        </Page>
    }
}

