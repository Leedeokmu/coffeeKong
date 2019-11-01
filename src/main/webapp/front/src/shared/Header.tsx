import React from "react";
import {createStyles, makeStyles, Theme} from "@material-ui/core/styles";
import AppBar from "@material-ui/core/AppBar";
import {StylesHook} from "@material-ui/styles/makeStyles";
import {Styles} from "@material-ui/core/styles/withStyles";
import {StyleRules} from "@material-ui/styles";
import {Link} from "react-router-dom";
import Toolbar from "@material-ui/core/Toolbar";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import Menu from "@material-ui/core/Menu";
import MenuItem from "@material-ui/core/MenuItem";

const useStyles: StylesHook<Styles<Theme, {}, string>> = makeStyles((theme: Theme): StyleRules =>
    createStyles({
        title: {
            flexGrow: 1
        }
    })
);

const Header = () => {
    const classes = useStyles();
    const [anchorEl, setAnchorEl] = React.useState<null | HTMLElement>(null);

    const _handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setAnchorEl(event.currentTarget);
    };

    const _handleClose = () => {
        setAnchorEl(null);
    };

    return (
        <AppBar position="static" color={"secondary"}>
            <Toolbar>
                <Link to={"/"} style={{textDecoration: 'none'}} className={classes.title}>
                    <Button variant={"contained"} color={"secondary"}>
                        <Typography variant={"h6"}>
                            Coffeekong
                        </Typography>
                    </Button>
                </Link>
                <Button aria-controls="about" aria-haspopup="true" onClick={_handleClick}>
                    About
                </Button>
                <Menu
                    id="about"
                    anchorEl={anchorEl}
                    open={Boolean(anchorEl)}
                    onClose={_handleClose}
                >
                    <MenuItem component={Link} to={"/intro"} onClick={_handleClose}>Introduction</MenuItem>
                    <MenuItem component={Link} to={"/location"} onClick={_handleClose}>Location</MenuItem>
                    <MenuItem component={Link} to={"/contact"} onClick={_handleClose}>Contact us</MenuItem>
                </Menu>
                <Link to={"/users"} style={{textDecoration: 'none'}}>
                    <Button color={"default"}>Learn</Button>
                </Link>
                <Link to={"/users"} style={{textDecoration: 'none'}}>
                    <Button color={"default"}>User Manage</Button>
                </Link>
            </Toolbar>
        </AppBar>
    );
}

export default Header;