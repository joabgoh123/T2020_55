import requests
import json
import os
# Create your views here.

def get_response(type, params):
    BASE_URL = 'http://techtrek-api-gateway.ap-southeast-1.elasticbeanstalk.com'
    HEADERS = {'identity': 'T13', 'token': '44d7fd0b-c154-40b2-b8bc-890f9eca6f67'}

    if type == 'customer_id':
        url = BASE_URL + '/customers' + '/' + params[0]

    elif type == 'customer_details':
        url = BASE_URL + '/customers' + '/' +params[0] + '/details'

    elif type == 'transaction_details':
        url = BASE_URL + '/transactions' + '/' + params[0] +'?from=' + params[1] + '&to=' + params[2]

    elif type == 'deposit_account':
        url = BASE_URL + '/accounts/deposit/' + params[0]

    elif type == 'deposit_account_balance':
        url = BASE_URL + '/accounts/deposit' + '/' + params[0] + '/balance?month=' + params[1] + '&year=' + params[2]

    elif type == 'marketing_messages':
        url = BASE_URL + '/marketing'

    elif type == 'marketing_message_details':
        url = BASE_URL + '/marketing' + params[0]

    elif type == 'personal_messages':
        url = BASE_URL + '/message' + params[0]

    response = requests.get(url=url, headers=HEADERS)
    data = json.loads(response.text)

    return data

def get_customer_info(username):
    type = 'customer_id'
    return get_response(type, [username])

def get_customer_details(username):
    data = get_customer_info(username)
    customerId = data['customerId']
    return get_response('customer_details', [customerId])

def get_deposit_account(username):
    data = get_customer_info(username)
    customerId = data['customerId']
    return get_response('deposit_account', [customerId])

def get_deposit_account_balance(username, params):
    accountId = str(get_deposit_account(username)['accountId'])
    return get_response('deposit_account_balance', [accountId,params[0],params[1]])

def get_marketing_messages():
    return get_response('marketing_messages', [])

def get_marketing_messages_details(params):
    return get_response('marketing_message_details', params[0])

def get_transaction_details(username, params):
    data = get_deposit_account(username)
    accountId = str(data[0]['accountId'])
    return get_response('transaction_details', [accountId,params[0],params[1]])







