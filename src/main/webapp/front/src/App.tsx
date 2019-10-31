import React from 'react';
import Header from "./shared/Header";
import Home from "./components/Home";
import Footer from "./shared/Footer";
import {Route, Switch} from "react-router-dom";
import Users from "./components/Users";
import {Container} from "@material-ui/core";

const App: React.FC<{}> = () => {
    return (
        <div className="App">
            <>
                <Container maxWidth="lg">
                    <Header/>
                    <Switch>
                        <Route exact={true} path={"/"} component={Home}/>
                        <Route path={"/learn"} component={Users}/>
                        <Route path={"/users"} component={Users}/>
                    </Switch>
                    <Footer/>
                </Container>
            </>
        </div>
    );
}

export default App;
