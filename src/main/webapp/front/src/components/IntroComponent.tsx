import React from "react"
import Grid from "@material-ui/core/Grid";
import {StylesHook} from "@material-ui/styles/makeStyles";
import {ClassNameMap, StyleRules, Styles} from "@material-ui/styles/withStyles";
import {createStyles, makeStyles, Theme} from "@material-ui/core";
import Typography from "@material-ui/core/Typography";

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
        <Grid container direction={"column"} justify={"center"} alignItems="center" className={classes.content} spacing={5}>
            <Grid item container justify={"center"}>
                <img src="img/happy.jpg" alt="Happy Face!" className={classes.happyFace} />
            </Grid>
            <Grid item>
                <Typography variant={"h4"}>WE ARE THE WORLD!</Typography>
            </Grid>
            <Grid item >
                <Typography gutterBottom >We are the world coffee publisher. 'You know coffee?' My father asked me in my childhood days. Always thinking 'what is coffee?' I always respect these aspact of coffee.</Typography>
            </Grid>
            <Grid item>
                <Typography variant={"h5"}>Welcome Friend</Typography>
            </Grid>
        </Grid>
    );
}
export default IntroComponent;
