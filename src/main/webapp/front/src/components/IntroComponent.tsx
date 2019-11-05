import React from "react"
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
        happyFace: {
            width: '30%',
            height: '30%',
            borderRadius: "5px"
        }
    })
);

const IntroComponent = () => {
    const classes: ClassNameMap = useStyles();
    return (
        <Grid container direction={"column"} alignItems={"center"} className={classes.content}>
            <Grid item>
                <img src="img/happy.jpg" alt="Happy Face!" className={classes.happyFace}/>
            </Grid>
            <Grid item>
                a
            </Grid>
            <Grid item>
                b
            </Grid>
        </Grid>
    );
}
export default IntroComponent;
