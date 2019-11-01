import React from 'react';
import Header from "./shared/Header";
import HomeContainer from "./containers/HomeContainer";
import Footer from "./shared/Footer";
import {Route, Switch} from "react-router-dom";
import Users from "./components/Users";
import Container from "@material-ui/core/Container";
import {GlobalStyle} from "./GlobalStyle";


const App = () => {
    return (
        <div className="App">
            <GlobalStyle/>
            <Container maxWidth="lg">
                <Header/>
                <Switch>
                    <Route exact={true} path={"/"} component={HomeContainer}/>
                    <Route path={"/learn"} component={Users}/>
                    <Route path={"/users"} component={Users}/>
                    <Route path={"/intro"} component={Users}/>
                    <Route path={"/location"} component={Users}/>
                    <Route path={"/contact"} component={Users}/>
                </Switch>
                <Footer/>
            </Container>
        </div>
    );
}

export default App;
