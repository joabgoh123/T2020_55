import pandas as pd
def cal_top_tag(data):
    df = pd.DataFrame.from_dict(data)
    tag_val_max = df.groupby('tag').count()['type']
    tag = pd.DataFrame(tag_val_max.sort_values().reset_index())["tag"].iloc[-1]
    return tag

def cal_savings(data):
    df = pd.DataFrame.from_dict(data)
    debit_amount = df[df['type'] == 'DEBIT']['amount'].astype('float').sum()
    credit_amount = df[df['type'] == 'CREDIT']['amount'].astype('float').sum()

    df['months'] = pd.DatetimeIndex(df['date']).month
    df['years'] = pd.DatetimeIndex(df['date']).year
    num_of_months = len(df[['months', 'years']].drop_duplicates())

    savings = (credit_amount - debit_amount) / num_of_months
    return str(savings)