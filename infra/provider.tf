terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "4.40.0"
    }
  }
  backend "s3" {
    bucket = "pgr301-2021-terraform-state"
    key    = "1031/cloudwatch-alarm.state"
    region = "eu-west-1"
  }

}