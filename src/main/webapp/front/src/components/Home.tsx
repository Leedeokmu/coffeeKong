import React from 'react';
import {createStyles, makeStyles, Theme} from '@material-ui/core/styles';
import {ClassNameMap, StyleRules, Styles} from "@material-ui/styles/withStyles";
import Grid from '@material-ui/core/Grid';
import Typography from "@material-ui/core/Typography";
import grey from "@material-ui/core/colors/grey";
import {StylesHook} from "@material-ui/styles/makeStyles";
import {Carousel} from "react-responsive-carousel";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Divider from '@material-ui/core/Divider';
import Paper from '@material-ui/core/Paper';
import {Link} from "react-router-dom";

const useStyles: StylesHook<Styles<Theme, {}, string>> = makeStyles((theme: Theme): StyleRules =>
    createStyles({
        content: {
            ...theme.mixins.gutters(),
            paddingTop: theme.spacing(2),
            paddingBottom: theme.spacing(2),
        },
        grid: {
            height: 500,
        },
        paper: {
            padding: theme.spacing(8,8,8,8)
        },
        image: {
            margin: 10,
            width: 400,
            height: 400,
        },
        entranceFont: {
            color: grey['500'],
        },
        imageButton: {
            margin: 10,
            width: 200,
            height: 200,
        }
    })
);

const carouselImages: string[] = [
    'coffee-beans',
    'coffee-cup',
    'coffee-drying',
    'coffee-grind',
    'coffee-ground'
]

const Home: React.FC<{}> = () => {
    const classes: ClassNameMap = useStyles();
    return (
        <div className={classes.content}>

            <Grid container direction="column" justify="space-between" alignItems="center">
                <Grid item className={classes.grid}>
                    <Carousel width="50em" autoPlay={true} showThumbs={false} infiniteLoop={true} centerMode={true}>
                        {carouselImages.map(imgName => (
                            <div key={imgName}>
                                <img alt={imgName} src={`img/${imgName}.jpg`} className={classes.image}/>
                                <p className={"legend"}>{imgName}</p>
                            </div>
                        ))}
                    </Carousel>
                </Grid>
                <Grid item >
                    <Paper elevation={5} className={classes.paper}>
                    <Typography variant={"h4"} paragraph={true} align={"center"} className={classes.entranceFont}>
                        "high quality coffee bean seller"
                    </Typography>
                    <Typography variant={"h6"} paragraph={true} align={"center"} className={classes.entranceFont}>
                        We match you with coffees you'll love from over 30 of the country's best award-winning artisan coffee roasters.
                        All coffee is roasted for your order and shipped directly to you.
                        <br/>
                        <br/>
                        When you get a Coffeekong coffee service, you get matched with a coffee curator - a coffee expert who learns the kinds of coffee
                        you like and sends you coffee based on your preferences.
                    </Typography>
                    </Paper>
                </Grid>
                <Grid container item justify={"center"}>
                    <Card className={classes.imageButton}>
                        <CardActionArea>
                            <Link to={"/users"} style={{textDecoration:'none'}}>
                            <CardMedia
                                component="img"
                                alt="coffee"
                                image="img/coffees.jpg"
                                title="coffee"
                            />
                            <CardContent>
                                <Typography align={"center"}>COFFEE</Typography>
                            </CardContent>
                            </Link>
                        </CardActionArea>
                    </Card>
                    <Card className={classes.imageButton}>
                        <CardActionArea>
                            <Link to={"/users"} style={{textDecoration:'none'}}>
                                <CardMedia
                                    component="img"
                                    alt="tools"
                                    image="img/tools.jpg"
                                    title="tools"
                                />
                                <CardContent>
                                    <Typography align={"center"}>TOOLS</Typography>
                                </CardContent>
                            </Link>
                        </CardActionArea>
                    </Card>
                    <Card className={classes.imageButton}>
                        <CardActionArea>
                            <Link to={"/learn"} style={{textDecoration:'none'}}>
                                <CardMedia
                                    component="img"
                                    alt="learn"
                                    image="img/coffee_learn.jpg"
                                    title="learn"
                                />
                                <CardContent>
                                    <Typography align={"center"}>LEARN</Typography>
                                </CardContent>
                            </Link>
                        </CardActionArea>
                    </Card>
                </Grid>
            </Grid>
        </div>
    )
}
export default Home;