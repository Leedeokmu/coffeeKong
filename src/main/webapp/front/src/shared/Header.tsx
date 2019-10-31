import React from "react";
import {createStyles, makeStyles, Theme} from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Button from "@material-ui/core/Button";
import {StylesHook} from "@material-ui/styles/makeStyles";
import {Styles} from "@material-ui/core/styles/withStyles";
import {StyleRules} from "@material-ui/styles";
import {Link} from "react-router-dom";

const useStyles: StylesHook<Styles<Theme, {}, string>> = makeStyles((theme: Theme): StyleRules =>
    createStyles({
        title: {
            flexGrow: 1
        }
    })
);

const Header : React.FC<{}> = () => {
    const classes = useStyles();
    return (
        <>
            <AppBar position="static" color={"default"}>
                <Toolbar>
                    <Link to={"/"} style={{textDecoration:'none'}} className={classes.title}>
                        <Button color={"default"}>Coffeekong</Button>
                    </Link>
                    <Link to={"/users"} style={{textDecoration:'none'}}>
                        <Button color={"default"}>About</Button>
                    </Link>
                    <Link to={"/users"} style={{textDecoration:'none'}}>
                        <Button color={"default"}>Learn</Button>
                    </Link>
                    <Link to={"/users"} style={{textDecoration:'none'}}>
                        <Button color={"default"}>User Manage</Button>
                    </Link>
                </Toolbar>
            </AppBar>
        </>
    );
}

export default Header;