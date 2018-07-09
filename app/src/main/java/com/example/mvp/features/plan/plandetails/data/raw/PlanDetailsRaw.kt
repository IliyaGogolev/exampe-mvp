package com.example.mvp.features.plan.plandetails.data.raw

/**
 * Created by Iliya Gogolev on 6/29/18.
 */
data class PlanDetailsRaw(val id:Int,
                          val name:String,
                          val athleteFirstName:String,
                          val athleteLastName:String,
                          val athleteImageUrl:String,
                          val description:String,
                          val daysCount:Int,
                          val displayDaysCountInWeeks:Boolean,
                          val imageUrl:String
                          // so on...
                          )