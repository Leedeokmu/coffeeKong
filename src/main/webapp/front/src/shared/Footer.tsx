import React from 'react';
import {createStyles, makeStyles, Theme} from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import {StylesHook} from "@material-ui/styles/makeStyles";
import {StyleRules, Styles} from "@material-ui/styles/withStyles";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import Tooltip from '@material-ui/core/Tooltip';
import {CardImage, Image} from "../interface/Interfaces";

const useStyles: StylesHook<Styles<Theme, {}, string>> = makeStyles((theme: Theme): StyleRules =>
    createStyles({
        root: {
            ...theme.mixins.gutters(),
            paddingTop: theme.spacing(2),
            paddingBottom: theme.spacing(2),
        },
        footerImg: {
            margin: 10,
            width: 30,
            height: 30,
        },
    })
);

const brandImages: Image[] = [
    {
        alt: 'b-corp-seal',
        src: 'img/b-corp-seal.png'
    }, {
        alt: 'certified-kosher.png',
        src: 'img/certified-kosher.png'
    }, {
        alt: 'cooperative-coffees.png',
        src: 'img/cooperative-coffees.png'
    },
];

const snsImages: CardImage[] = [
    {
        image: {
            alt: 'facebook',
            src: 'img/facebook_new.png'
        },
        link: 'http://www.facebook.com'
    }, {
        image: {
            alt: 'twitter',
            src: 'img/twitter_new.png'
        },
        link: 'http://www.twitter.com'
    }, {
        image: {
            alt: 'youtube',
            src: 'img/youtube_new.png'
        },
        link: 'http://www.youtube.com'
    },
];

const Footer = () => {
    const classes = useStyles();
    return (
        <footer>
            <Paper className={classes.root} elevation={1}>
                <Grid container justify="space-between">
                    <Grid item>
                        {brandImages.map(image => (
                            <img key={image.alt} alt={image.alt} src={image.src} className={classes.footerImg}/>
                        ))}
                    </Grid>
                    <Grid item>
                        {snsImages.map(image => (
                            <Tooltip title={image.image.alt} key={image.image.alt}>
                                <a href={image.link} target={"_blank"} >
                                    <img alt={image.image.alt} src={image.image.src} className={classes.footerImg}/>
                                </a>
                            </Tooltip>
                        ))}
                    </Grid>
                </Grid>
                <Typography variant={"body1"}>
                    © 2016 CoffeeKong. All Rights Reserved to freeefly.
                </Typography>
            </Paper>
        </footer>
    );
};

export default Footer;