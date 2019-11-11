import React from "react";
import Grid from "@material-ui/core/Grid";
import {StylesHook} from "@material-ui/styles/makeStyles";
import {ClassNameMap, StyleRules, Styles} from "@material-ui/styles/withStyles";
import {createStyles, makeStyles, Theme} from "@material-ui/core";


const useStyles: StylesHook<Styles<Theme, {}, string>> = makeStyles((theme: Theme): StyleRules =>
    createStyles({
        content: {
            ...theme.mixins.gutters(),
            paddingTop: theme.spacing(2),
            paddingBottom: theme.spacing(2),
        },
    })
);


const  ContactComponent = () => {
    const classes: ClassNameMap = useStyles();
    return (
        <Grid container justify={"center"} className={classes.content}>
            <Grid item>CONTACT US</Grid>
            <Grid item>

            </Grid>
            <Grid item></Grid>
            <Grid item></Grid>
        </Grid>
    )
}

export default ContactComponent;