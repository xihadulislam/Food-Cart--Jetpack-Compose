package com.xihadulislam.foodcart.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xihadulislam.foodcart.Destinations
import com.xihadulislam.foodcart.R
import com.xihadulislam.foodcart.models.PopularData
import com.xihadulislam.foodcart.ui.theme.*


@Composable
fun DetailScreen(navController: NavController) {

    Scaffold(
        topBar = {
            DetailHeader(navController = navController)
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(start = 30.dp, top = 0.dp, end = 30.dp)
            )
            {

                val data =
                    navController.previousBackStackEntry?.arguments?.getParcelable<PopularData>(
                        Destinations.DetailArgs.foodData
                    )

                if (data != null) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(
                                rememberScrollState()
                            )
                    ) {


                        Spacer(modifier = Modifier.height(32.dp))

                        Image(
                            painter = painterResource(id = data.resId),
                            contentDescription = "",
                            modifier = Modifier.size(275.dp)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                        )
                        {
                            Column(verticalArrangement = Arrangement.SpaceBetween) {

                                Text(
                                    text = data.title, style = Typography.body1,
                                    fontSize = 22.sp,
                                    color = BlackTextColor
                                )


                                Box(
                                    modifier = Modifier
                                        .height(40.dp),
                                    contentAlignment = Alignment.Center
                                )
                                {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Text(
                                            text = "$",
                                            style = Typography.body1,
                                            fontSize = 14.sp,
                                            color = Orange500
                                        )

                                        Text(
                                            text = "${data.price}",
                                            style = Typography.body1,
                                            fontSize = 20.sp,
                                            color = BlackTextColor
                                        )
                                    }
                                }
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {

                                BoxWithRes(
                                    resId = R.drawable.minus,
                                    description = "Minus",
                                    iconSize = 16,
                                    boxSize = 36,
                                    iconColor = BlackTextColor
                                )

                                Spacer(modifier = Modifier.width(14.dp))

                                Text(
                                    text = "01",
                                    style = Typography.body2,
                                    fontSize = 18.sp,
                                    color = BlackTextColor
                                )

                                Spacer(modifier = Modifier.width(14.dp))

                                BoxWithRes(
                                    resId = R.drawable.add,
                                    description = "Add",
                                    iconSize = 16,
                                    boxSize = 36,
                                    iconColor = Color.White,
                                    bgColor = Yellow500
                                )
                            }

                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = data.description,
                            style = Typography.h5,
                            fontSize = 16.sp,
                            color = TextColor,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        DetailBox(data = data)

                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Ingradients",
                            style = Typography.body1,
                            fontSize = 22.sp,
                            color = BlackTextColor,
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        )
                        {
                            items(data.ingradients.size) { index ->
                                Box(
                                    modifier = Modifier
                                        .size(56.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(
                                            CardItemBg
                                        ), contentAlignment = Alignment.Center
                                )
                                {
                                    Image(
                                        painter = painterResource(id = data.ingradients[index]),
                                        contentDescription = "",
                                        modifier = Modifier.size(width = 30.dp, height = 24.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Box(
                            modifier = Modifier
                                .size(width = 203.dp, height = 56.dp)
                                .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                                .background(
                                    Yellow500
                                ), contentAlignment = Alignment.Center
                        )
                        {
                            Text(
                                text = "Add to card",
                                style = Typography.body1,
                                color = Color.White
                            )
                        }

                    }

                }
            }
        }
    )


}

@Composable
fun DetailHeader(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(8.dp)
    ) {

        BoxWithRes(
            resId = R.drawable.arrow_left,
            description = "Left",
            navController = navController
        )



        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    CardItemBg
                ), contentAlignment = Alignment.Center
        )
        {
            Box(
                modifier = Modifier
                    .size(24.dp)
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.bag),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = IconColor
                )

                Box(
                    modifier = Modifier
                        .padding(top = 2.dp, end = 2.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                )
                {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(
                                Yellow500
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun DetailBox(data: PopularData) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                CardItemBg
            )
            .padding(15.dp)
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Row {
                Image(
                    painter = painterResource(id = R.drawable.calori),
                    contentDescription = "Calori",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.calori} kcal",
                    style = Typography.body2,
                    color = BlackTextColor
                )
            }

            Divider(
                color = DividerColor, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )


            Row {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Star",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.rate}",
                    style = Typography.body2,
                    color = BlackTextColor
                )
            }

            Divider(
                color = DividerColor, modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )

            Row {

                Image(
                    painter = painterResource(id = R.drawable.schedule),
                    contentDescription = "Schedule",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.scheduleTime} Min",
                    style = Typography.body2,
                    color = BlackTextColor
                )
            }

        }
    }
}