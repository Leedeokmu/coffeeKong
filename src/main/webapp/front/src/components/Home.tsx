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
            width: 300,
            height: 300,
        }
    })
);

interface Image {
    alt: string;
    src: string;
}

interface CardImage {
    image: Image;
    link: string;
}
interface ICoffeeCarousel {
    images: Image[]
}
interface ICardButton {
    card: CardImage;
}

const carouselImages: Image[] = [
    {
        alt: 'coffee-beans',
        src: 'img/coffee-beans.jpg'
    },{
        alt: 'coffee-ground',
        src: 'img/coffee-ground.jpg'
    },{
        alt: 'coffee-cup',
        src: 'img/coffee-cup.jpg'
    },{
        alt: 'coffee-drying',
        src: 'img/coffee-drying.jpg'
    },{
        alt: 'coffee-ground',
        src: 'img/coffee-ground.jpg'
    }
];

const cardButtonImages: CardImage[] = [
    {
        image: {
            alt: 'coffees',
            src: 'img/coffees.jpg'
        },
        link: '/users'
    },{
        image: {
            alt: 'tools',
            src: 'img/tools.jpg'
        },
        link: '/users'
    },
    {
        image: {
            alt: 'learn',
            src: 'img/learn.jpg'
        },
        link: '/users'
    }
];

const CoffeeCarousel = (props : ICoffeeCarousel) => {
    const classes: ClassNameMap = useStyles();
    const {images} = props;
    return (
        <Carousel width="70em" autoPlay={true} showThumbs={false} infiniteLoop={true} centerMode={true}>
            {images.map(img => (
                <div key={img.alt}>
                    <img alt={img.alt} src={img.src} className={classes.image}/>
                    <p className={"legend"}>{img.alt}</p>
                </div>
            ))}
        </Carousel>
    )
}

const EntranceMessage = () => {
    const classes = useStyles();
    return (
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
    )
}


const CardButton = (props: ICardButton) => {
    const classes = useStyles();
    const {card} = props;
    return (
        <Card className={classes.imageButton} >
            <CardActionArea  style={{height:'100%'}}>
                <Link to={card.link} style={{textDecoration: 'none'}}>
                    <CardMedia
                        component="img"
                        alt={card.image.alt}
                        image={card.image.src}
                        title={card.image.alt}
                    />
                    <CardContent>
                        <Typography variant={'h6'} align={"center"}>{card.image.alt}</Typography>
                    </CardContent>
                </Link>
            </CardActionArea>
        </Card>
    )

};

const Home = () => {
    const classes: ClassNameMap = useStyles();

    return (
        <div className={classes.content}>
            <Grid container justify="center" alignItems="center">
                <Grid item className={classes.grid}>
                    <CoffeeCarousel images={carouselImages}/>
                </Grid>
                <Grid item>
                    <EntranceMessage/>
                </Grid>
                <Grid container item justify={"center"}>
                    {cardButtonImages.map(card => (
                        <CardButton card={card} key={card.image.alt}/>
                    ))}
                </Grid>
            </Grid>
        </div>
    )
}
export default Home;