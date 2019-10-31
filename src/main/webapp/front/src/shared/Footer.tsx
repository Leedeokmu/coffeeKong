import React from 'react';
import {createStyles, makeStyles, Theme} from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import {StylesHook} from "@material-ui/styles/makeStyles";
import {StyleRules, Styles} from "@material-ui/styles/withStyles";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";

const useStyles: StylesHook<Styles<Theme, {}, string>> = makeStyles((theme: Theme): StyleRules =>
    createStyles({
        root: {
            ...theme.mixins.gutters(),
            paddingTop: theme.spacing(2),
            paddingBottom: theme.spacing(2),
        },
        footer: {
            backgroundColor: theme.palette.background.paper,
            marginTop: theme.spacing(8),
            padding: `${theme.spacing(6)}px 0`,
        },
        footerImg: {
            margin: 10,
            width: 30,
            height: 30,
        },
    })
);

const Footer: React.FC<{}> = () => {
    const classes = useStyles();
    return (
        <footer className={classes.footer}>
            <Paper className={classes.root} elevation={1}>
                <Grid container justify="space-between" >
                    <Grid>
                        <img alt="b-corp-seal" src="img/b-corp-seal.png" className={classes.footerImg}/>
                        <img alt="certified-kosher.png" src="img/certified-kosher.png" className={classes.footerImg}/>
                        <img alt="cooperative-coffees.png" src="img/cooperative-coffees.png" className={classes.footerImg}/>
                    </Grid>
                    <Grid>
                        <a href="http://www.facebook.com" target={"_blank"}>
                            <img alt="facebook_new" src="img/facebook_new.png" className={classes.footerImg}/>
                        </a>
                        <a href="http://www.twitter.com" target={"_blank"}>
                            <img alt="twitter_new" src="img/twitter_new.png" className={classes.footerImg}/>
                        </a>
                        <a href="http://www.youtube.com" target={"_blank"}>
                            <img alt="youtube_new" src="img/youtube_new.png" className={classes.footerImg}/>
                        </a>
                    </Grid>
                </Grid>
                <Typography variant="h6">
                    © 2016 CoffeeKong. All Rights Reserved to freeefly.
                </Typography>
            </Paper>

        </footer>
    );
}

export default Footer;