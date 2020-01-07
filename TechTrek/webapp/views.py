from django.shortcuts import render
from django.http import HttpResponse
import os
from . import utils
from . import process_data

# Create your views here.
def index(request):
    current_user = request.user.username
    data = utils.get_transaction_details(current_user,['01-01-2018','01-30-2020'])
    top_tag = process_data.cal_top_tag(data)
    avg_savings = process_data.cal_savings(data)

    if top_tag == "TRANSFER":
        
    return HttpResponse("Hi " + current_user + " your top category of spending is "+ top_tag + "  and avg savings  is " + avg_savings)

