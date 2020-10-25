import React from "react";

export default class CommunicationInitializerScreen extends React.Component {
    render() {
        return <div>{this.props.initialize ? "INITIALIZE" : "CONNECT"}</div>
    }
}

